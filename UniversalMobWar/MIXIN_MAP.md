# UMW mixin porting: yarn method -> official 26.2 method (VERIFIED via javap)

Target class renames (in @Mixin(...) and casts):
- MobEntity.class -> net.minecraft.world.entity.Mob
- LivingEntity.class -> net.minecraft.world.entity.LivingEntity
- Entity.class -> net.minecraft.world.entity.Entity
- PlayerEntity -> net.minecraft.world.entity.player.Player
- CreeperEntity -> net.minecraft.world.entity.monster.Creeper
- EndermanEntity -> net.minecraft.world.entity.monster.EnderMan
- WitchEntity -> net.minecraft.world.entity.monster.Witch
- PersistentProjectileEntity -> net.minecraft.world.entity.projectile.arrow.AbstractArrow
- ExplosiveProjectileEntity -> net.minecraft.world.entity.projectile.hurtingprojectile.AbstractHurtingProjectile
- PotionEntity -> verify: net.minecraft.world.entity.projectile.throwableitem.ThrownSplashPotion / AbstractThrownPotion (USE JAVAP to confirm exact class + onHit method)
- ThrownItemEntity -> net.minecraft.world.entity.projectile.throwableitem.ThrowableItemProjectile (verify)
- Angerable -> net.minecraft.world.entity.NeutralMob
- NbtCompound -> (NBT save API replaced; see below)
- ServerWorld -> net.minecraft.server.level.ServerLevel ; World -> net.minecraft.world.level.Level
- SpawnReason -> net.minecraft.world.entity.EntitySpawnReason (VERIFIED values: NATURAL, SPAWNER, SPAWN_ITEM_USE (this is the OLD 'SPAWN_EGG'), COMMAND, MOB_SUMMONED, CHUNK_GENERATION, BREEDING, STRUCTURE, etc. NOTE: there is NO SPAWN_EGG; use SPAWN_ITEM_USE for spawn-egg detection.)
- EquipmentSlot -> net.minecraft.world.entity.EquipmentSlot (same); ItemStack.EMPTY same
- DamageSource -> net.minecraft.world.damagesource.DamageSource

VERIFIED method renames (mixin @Inject method= targets):
- mobTick / tickMovement customServerAiStep : yarn "mobTick" -> "customServerAiStep" (now takes ServerLevel arg: signature (Lnet/minecraft/server/level/ServerLevel;)V). Inject accordingly; if you need the arg, add ServerLevel param.
- tryAttack(Entity)Z -> doHurtTarget : "doHurtTarget(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/Entity;)Z" returns boolean. Args now (ServerLevel, Entity).
- initialize(...) -> finalizeSpawn : "finalizeSpawn(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/world/DifficultyInstance;Lnet/minecraft/world/entity/EntitySpawnReason;Lnet/minecraft/world/entity/SpawnGroupData;)Lnet/minecraft/world/entity/SpawnGroupData;". Params: ServerLevelAccessor, DifficultyInstance, EntitySpawnReason, SpawnGroupData; returns SpawnGroupData (CallbackInfoReturnable<SpawnGroupData>).
- onDeath(DamageSource) -> die : "die(Lnet/minecraft/world/damagesource/DamageSource;)V"
- handleAttack(Entity)Z -> skipAttackInteraction : "skipAttackInteraction(Lnet/minecraft/world/entity/Entity;)Z" returns boolean
- damage(DamageSource,float)Z -> hurtServer : "hurtServer(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/damagesource/DamageSource;F)Z" (args ServerLevel, DamageSource, float)
- onCollision(HitResult) -> onHit : verify exact ("onHit(Lnet/minecraft/world/phys/HitResult;)V") via javap on the projectile class

VERIFIED entity method renames (inside mixin bodies):
- getWorld() -> level()
- isClient() -> isClientSide()
- getUuid() -> getUUID()
- addCommandTag(s) -> addTag / getTags
- getTime() -> level().getGameTime()
- getAttacker() (DamageSource) -> getEntity()  (verify getEntity vs getDirectEntity)
- equipStack(slot, stack) -> setItemSlot(slot, stack)
- setTarget/getTarget same
- getType() same
- Angerable.getAngryAt()->getPersistentAngerTarget(); setAngryAt(uuid)->setPersistentAngerTarget(uuid); setAngerTime(t)->setRemainingPersistentAngerTime(t)  (VERIFY all three via javap on NeutralMob)
- world.getEntitiesByClass(...) -> level().getEntitiesOfClass(...)  (verify)
- boundingBox.expand(x) -> inflate(x)
- getOwner() same on projectile

NBT SAVE API (writeCustomDataToNbt/readCustomDataFromNbt) -> DO NOT PORT THESE; Phoenix handles MobDataMixin + MobWarData serialization (ValueOutput/ValueInput). Leave MobDataMixin.java alone.

Accessors:
- MobEntityAccessor @Accessor("targetSelector"/"goalSelector") -> fields still exist on Mob (targetSelector/goalSelector). Just change @Mixin(Mob.class) + import.
- CreeperEntityAccessor, PersistentProjectileEntityAccessor, ExplosiveProjectileEntityAccessor: retarget class, VERIFY the accessed field names via javap (field names may have changed, e.g. Creeper explosionRadius -> explosionRadius? check).

GoalSelector: add(pri, goal) -> addGoal(pri, goal); getGoals() -> getAvailableGoals().

RULE: verify EVERY @Inject method descriptor and every accessed field name against javap before finalizing. A wrong descriptor = silent mixin failure at runtime. Use:
& "C:\Java\jdk-25.0.3+9\bin\javap.exe" -p -cp "$env:USERPROFILE\umw-mc26\common.jar;$env:USERPROFILE\umw-mc26\client.jar" <Class>
(-p shows private fields for accessors.)
