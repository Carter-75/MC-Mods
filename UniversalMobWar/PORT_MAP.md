# UMW yarn -> MC 26.2 official mappings (VERIFIED via javap on reference jars)

Reference jars: `%USERPROFILE%\umw-mc26\common.jar` + `client.jar`
javap: `& "C:\Java\jdk-25.0.3+9\bin\javap.exe" -p -cp "$env:USERPROFILE\umw-mc26\common.jar;$env:USERPROFILE\umw-mc26\client.jar" <FQCN>`

## PACKAGE / CLASS IMPORT REMAP (yarn import -> official import)

### Text / chat
- net.minecraft.text.Text                    -> net.minecraft.network.chat.Component   (rename Text -> Component everywhere)
- net.minecraft.text.MutableText             -> net.minecraft.network.chat.MutableComponent
- Text.literal("x")   -> Component.literal("x")
- Text.translatable  -> Component.translatable
- Formatting          -> net.minecraft.ChatFormatting  (VERIFY name via javap if used)

### Identifier (NOTE: NOT renamed to ResourceLocation in this build)
- net.minecraft.util.Identifier              -> net.minecraft.resources.Identifier

### Entity core
- net.minecraft.entity.mob.MobEntity          -> net.minecraft.world.entity.Mob
- net.minecraft.entity.LivingEntity           -> net.minecraft.world.entity.LivingEntity
- net.minecraft.entity.Entity                 -> net.minecraft.world.entity.Entity
- net.minecraft.entity.EntityType             -> net.minecraft.world.entity.EntityType
- net.minecraft.entity.player.PlayerEntity    -> net.minecraft.world.entity.player.Player
- net.minecraft.server.network.ServerPlayerEntity -> net.minecraft.server.level.ServerPlayer
- net.minecraft.entity.mob.Angerable          -> net.minecraft.world.entity.NeutralMob
- net.minecraft.entity.SpawnReason            -> net.minecraft.world.entity.EntitySpawnReason
- net.minecraft.entity.SpawnGroup             -> net.minecraft.world.entity.MobCategory
- net.minecraft.entity.EntityData/SpawnData   -> net.minecraft.world.entity.SpawnGroupData
- net.minecraft.entity.AgeableEntity/Mob      -> net.minecraft.world.entity.AgeableMob
- net.minecraft.entity.ExperienceOrbEntity    -> net.minecraft.world.entity.ExperienceOrb

### Monsters
- CreeperEntity   -> net.minecraft.world.entity.monster.Creeper
- EndermanEntity  -> net.minecraft.world.entity.monster.EnderMan
- WitchEntity     -> net.minecraft.world.entity.monster.Witch

### Projectiles
- PersistentProjectileEntity        -> net.minecraft.world.entity.projectile.arrow.AbstractArrow
- ExplosiveProjectileEntity         -> net.minecraft.world.entity.projectile.hurtingprojectile.AbstractHurtingProjectile
- PotionEntity / ThrownPotion       -> net.minecraft.world.entity.projectile.throwableitemprojectile.AbstractThrownPotion
    (concrete: ThrownSplashPotion, ThrownLingeringPotion in same package)

### Attributes
- net.minecraft.entity.attribute.EntityAttributes         -> net.minecraft.world.entity.ai.attributes.Attributes
- net.minecraft.entity.attribute.DefaultAttributeContainer-> net.minecraft.world.entity.ai.attributes.AttributeSupplier
- EntityAttributeModifier                                 -> net.minecraft.world.entity.ai.attributes.AttributeModifier

### Damage / effects
- net.minecraft.entity.damage.DamageSource   -> net.minecraft.world.damagesource.DamageSource
- net.minecraft.entity.effect.StatusEffectInstance -> net.minecraft.world.effect.MobEffectInstance
- net.minecraft.entity.effect.StatusEffects        -> net.minecraft.world.effect.MobEffects
- StatusEffect (the type)                          -> net.minecraft.world.effect.MobEffect (VERIFY)

### Data tracker (entity synched data)
- net.minecraft.entity.data.DataTracker            -> net.minecraft.network.syncher.SynchedEntityData
- net.minecraft.entity.data.TrackedData<T>         -> net.minecraft.network.syncher.EntityDataAccessor<T>
- net.minecraft.entity.data.TrackedDataHandlerRegistry -> net.minecraft.network.syncher.EntityDataSerializers

### Items / components
- net.minecraft.item.ItemStack               -> net.minecraft.world.item.ItemStack
- net.minecraft.item.Items                   -> net.minecraft.world.item.Items
- net.minecraft.item.Item                    -> net.minecraft.world.item.Item
- net.minecraft.component.DataComponentTypes  -> net.minecraft.core.component.DataComponents
- net.minecraft.component.type.PotionContentsComponent -> net.minecraft.world.item.alchemy.PotionContents

### Enchantment
- net.minecraft.enchantment.Enchantment       -> net.minecraft.world.item.enchantment.Enchantment
- net.minecraft.enchantment.EnchantmentHelper -> net.minecraft.world.item.enchantment.EnchantmentHelper
- net.minecraft.enchantment.Enchantments      -> net.minecraft.world.item.enchantment.Enchantments (VERIFY)

### World / level
- net.minecraft.server.world.ServerWorld     -> net.minecraft.server.level.ServerLevel
- net.minecraft.world.World                  -> net.minecraft.world.level.Level
- net.minecraft.world.ServerWorldAccess/WorldAccess -> net.minecraft.world.level.ServerLevelAccessor
- net.minecraft.world.LocalDifficulty        -> net.minecraft.world.DifficultyInstance

### Sound / particle / math
- net.minecraft.sound.SoundEvents            -> net.minecraft.sounds.SoundEvents
- net.minecraft.sound.SoundCategory          -> net.minecraft.sounds.SoundSource (VERIFY)
- net.minecraft.particle.ParticleTypes       -> net.minecraft.core.particles.ParticleTypes
- net.minecraft.util.math.Vec3d              -> net.minecraft.world.phys.Vec3
- net.minecraft.util.math.BlockPos           -> net.minecraft.core.BlockPos
- net.minecraft.util.math.Box                -> net.minecraft.world.phys.AABB (VERIFY)
- net.minecraft.util.hit.HitResult           -> net.minecraft.world.phys.HitResult
- net.minecraft.util.math.random.Random      -> net.minecraft.util.RandomSource

### Boss bar
- net.minecraft.entity.boss.BossBar          -> net.minecraft.world.BossEvent
- net.minecraft.entity.boss.ServerBossBar    -> net.minecraft.server.level.ServerBossEvent

### Registry
- net.minecraft.registry.Registry            -> net.minecraft.core.Registry
- net.minecraft.registry.Registries          -> net.minecraft.core.registries.BuiltInRegistries (VERIFY)
- net.minecraft.registry.entry.RegistryEntry -> net.minecraft.core.Holder
- net.minecraft.registry.RegistryKey         -> net.minecraft.resources.ResourceKey (VERIFY)

### Commands
- net.minecraft.server.command.ServerCommandSource -> net.minecraft.commands.CommandSourceStack
- net.minecraft.server.command.CommandManager      -> net.minecraft.commands.Commands
- net.minecraft.command.CommandRegistryAccess      -> net.minecraft.commands.CommandBuildContext
- net.minecraft.command.argument.*                 -> net.minecraft.commands.arguments.* (VERIFY per-arg)

## METHOD RENAMES (call sites)
- getWorld()            -> level()
- isClient()            -> isClientSide()  (Level.isClientSide field on Level)
- getUuid()             -> getUUID()
- world.getEntitiesByClass / getOtherEntities -> level().getEntitiesOfClass(...)
- box.expand(n)         -> box.inflate(n)
- equipStack(slot,st)   -> setItemSlot(slot, st)
- getEquippedStack(slot)-> getItemBySlot(slot)
- getStackInHand        -> getItemInHand
- setTarget/getTarget   -> same
- getAttacker() on DamageSource -> getEntity()  (or getDirectEntity() for projectile)
- Angerable.getAngryAt()      -> NeutralMob.getPersistentAngerTarget()
- Angerable.setAngryAt(uuid)  -> setPersistentAngerTarget(uuid)
- Angerable.setAngerTime(t)   -> setRemainingPersistentAngerTime(t)
- goalSelector.add(pri,goal)  -> addGoal(pri, goal)
- goalSelector.getGoals()     -> getAvailableGoals()
- Text.literal -> Component.literal
- sendMessage(text, bool)     -> VERIFY new signature (Player.displayClientMessage(Component, boolean) or sendSystemMessage)
- addStatusEffect(inst)       -> addEffect(inst) (VERIFY)
- damage(source, amt)         -> hurt / hurtServer(ServerLevel, DamageSource, float) (VERIFY exact for context)

## RULE
Verify every uncertain FQCN/method via javap BEFORE finalizing. Wrong mixin descriptor = silent runtime failure.
For mixin @Inject descriptors, see MIXIN_MAP.md (already verified there).
