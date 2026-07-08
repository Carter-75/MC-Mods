-- Cyber, GreatKingKeenan and Axolotl were here :3

local l = bl and 1 or -1
local d = (bl and 1) or -0.43
local a = (bl and 1) or 0.8


renderAsBlock:put("minecraft:pointed_dripstone", false)
renderAsBlock:put("minecraft:small_amethyst_bud", false)
renderAsBlock:put("minecraft:medium_amethyst_bud", false)
renderAsBlock:put("minecraft:large_amethyst_bud", false)
renderAsBlock:put("minecraft:amethyst_cluster", false)
renderAsBlock:put("minecraft:resin_clump", false)

-- Named Variants
if ( 
	not string.find(I:getActualName(item), "Display Case")
) then

-- Iron Ingot, Copper Ingot, Gold Ingot, Netherite Ingot, Brick, Resin Brick, Nether Brick
if (
	I:isOf(item, Items:get("minecraft:iron_ingot")) or
	I:isOf(item, Items:get("minecraft:copper_ingot")) or
	I:isOf(item, Items:get("minecraft:gold_ingot")) or
	I:isOf(item, Items:get("minecraft:netherite_ingot")) or
	I:isOf(item, Items:get("minecraft:brick")) or
	I:isOf(item, Items:get("minecraft:resin_brick")) or
	I:isOf(item, Items:get("minecraft:nether_brick"))
) then
	M:moveY(matrices, 0.1)
	M:moveX(matrices, -0.05 * l)
	M:moveZ(matrices, 0.15)
	
	M:rotateX(matrices, 0)
	M:rotateY(matrices, -30 * l)
	M:rotateZ(matrices, 90 * l)

	M:scale(matrices, 1.1, 1.1, 1.1)
end

-- Ingots
if  (
	string.find(I:getActualName(item), "Ingots")
) then
	M:moveY(matrices, 0)
	M:moveX(matrices, 0.05 * l)
	M:moveZ(matrices, 0)
	
	M:rotateX(matrices, 0)
	M:rotateY(matrices, 0 * l)
	M:rotateZ(matrices, 0 * l)
end

-- Lapis Lazuli
if I:isOf(item, Items:get("minecraft:lapis_lazuli"))
then
	M:moveY(matrices, 0.2)
	M:moveZ(matrices, 0.1)
	M:moveX(matrices, -0.025 * l)
	
	M:rotateX(matrices, -270)
	M:rotateY(matrices, -180 * l)
end

-- Emerald
if I:isOf(item, Items:get("minecraft:emerald")) then
	M:moveY(matrices, 0.2)
	M:moveZ(matrices, 0.18)
	M:moveX(matrices, 0)
	
	M:rotateY(matrices, 93 * l)
	M:rotateX(matrices, -50)
	M:rotateZ(matrices, -30 * l)
	
	M:scale(matrices, 1.3, 1.3, 1.3)
end

-- Ruby
if  (
	string.find(I:getActualName(item), "Ruby")
) then
	M:moveY(matrices, 0)
	M:moveX(matrices, -0.1 * l)
	M:moveZ(matrices, 0)
	
	M:rotateX(matrices, 0)
	M:rotateY(matrices, 0 * l)
	M:rotateZ(matrices, 0 * l)
end

-- Amethyst Shard, Echo Shard
if (
	I:isOf(item, Items:get("minecraft:amethyst_shard")) or
	I:isOf(item, Items:get("minecraft:echo_shard"))
) then
	M:moveY(matrices, 0.05)
	M:moveZ(matrices, 0)
	M:moveX(matrices, 0)

	M:rotateY(matrices, 0)
	M:rotateX(matrices, -40)
	M:rotateZ(matrices, 0)
	
	M:scale(matrices, 1.5, 1.5, 1.5)
end

-- Coal, Charcoal
if (
	I:isOf(item, Items:get("minecraft:coal")) or
	I:isOf(item, Items:get("minecraft:charcoal"))
) then
	M:moveY(matrices, 0.1)
	M:moveZ(matrices, 0.15)
	M:moveX(matrices, 0)

	M:rotateY(matrices, 160 * l)
	M:rotateX(matrices, -50)
	M:rotateZ(matrices, 0)
	
	M:scale(matrices, 1.3, 1.3, 1.3)
end

-- Netherite Scrap
if I:isOf(item, Items:get("minecraft:netherite_scrap")) then
	M:moveY(matrices, 0.1)
	M:moveZ(matrices, 0.15)
	M:moveX(matrices, -0.1 * l)

	M:rotateY(matrices, -90 * l)
	M:rotateX(matrices, 13)
	M:rotateZ(matrices, 90 * l)
	
	M:scale(matrices, 1.2, 1.2, 1.2)
end

-- Iron Nugget, Copper Nugget, Gold Nugget
if (
	I:isOf(item, Items:get("minecraft:iron_nugget")) or
	I:isOf(item, Items:get("minecraft:gold_nugget")) or
	I:isOf(item, Items:get("minecraft:copper_nugget"))
) then
	M:moveX(matrices, -0.05 * l)
	M:moveY(matrices, 0.15)
	M:moveZ(matrices, 0.1)
	
	M:rotateX(matrices, 0)
	
	M:scale(matrices, 1.3, 1.3, 1.3)
end

-- Gold Coin
if  (
	string.find(I:getActualName(item), "Coin")
) then
	M:moveY(matrices, -0.025)
	M:moveX(matrices, 0 * l)
	M:moveZ(matrices, -0.05)
	
	M:rotateX(matrices, 0)
	M:rotateY(matrices, 0 * l)
	M:rotateZ(matrices, 0 * l)

	M:scale(matrices, 0.7, 0.7, 0.7)
end

-- Redstone
if (
	I:isOf(item, Items:get("minecraft:redstone")) 
) then
	M:moveY(matrices, 0.09)
	M:moveZ(matrices, 0.25)
	M:moveX(matrices, -0.05 * l)
	
	M:rotateX(matrices, -45)

	M:scale(matrices, 1.3, 1.3, 1.3)

	I:setTranslate(item, false)
    
    particleManager:addParticle(
        particles, 
        false, 
        0 * l, 
        0.025, 
        0, 
        0, 
        0, 
        0, 
        0, 
        0, 
        0, 
        0, 
        0, 
        0, 
        1.1, 
        Texture:of("minecraft", "textures/particle/redstone_glow.png"), 
        "ITEM", 
        hand, 
        "SPAWN", 
        "ADDITIVE", 
        0, 
        200 + (20 * M:sin(P:getAge(player) * 0.2))
    )
end

-- Flint
if I:isOf(item, Items:get("minecraft:flint")) then
	M:moveY(matrices, 0.1)
	M:moveZ(matrices, 0.1)
	
	M:rotateY(matrices, 93 * l)
	M:rotateX(matrices, -50)
	M:rotateZ(matrices, -30 * l)
	
	M:scale(matrices, 1.5, 1.5, 1.5)
end

-- Raw Iron, Raw Copper, Raw Gold
if (
	I:isOf(item, Items:get("minecraft:raw_iron")) or
	I:isOf(item, Items:get("minecraft:raw_copper")) or
	I:isOf(item, Items:get("minecraft:raw_gold"))
) then
	M:moveY(matrices, 0.1)
	M:moveZ(matrices, 0.15)
	M:moveX(matrices, 0)

	M:rotateY(matrices, 160 * l)
	M:rotateX(matrices, -50)
	M:rotateZ(matrices, 0)

	M:scale(matrices, 1.2, 1.2, 1.2)
end

-- Resin Clump
if (
	I:isOf(item, Items:get("minecraft:resin_clump"))
) then
	M:moveY(matrices, 0)
	M:moveZ(matrices, 0.1)
	M:moveX(matrices, 0 * l)
	
	M:rotateY(matrices, -20)

	M:scale(matrices, 1.2, 1.2, 1.2)
end

-- Small Amethyst Bud, Medium Amethyst Bud, Large Amethyst Bud, Amethyst Cluster, Quartz
if (
	I:isOf(item, Items:get("minecraft:small_amethyst_bud")) or
	I:isOf(item, Items:get("minecraft:medium_amethyst_bud")) or
	I:isOf(item, Items:get("minecraft:large_amethyst_bud")) or
	I:isOf(item, Items:get("minecraft:quartz")) or
	I:isOf(item, Items:get("minecraft:amethyst_cluster"))
) then
	M:moveY(matrices, 0.05)
	M:moveZ(matrices, -0.05)
	M:moveX(matrices, 0 * l)
	
	M:rotateY(matrices, 0)
end

-- Pointed Dripstone
if (
	I:isOf(item, Items:get("minecraft:pointed_dripstone"))
) then
	M:moveY(matrices, 0.15)
	M:moveZ(matrices, 0.075)
	M:moveX(matrices, -0.1 * l)
	
	M:rotateY(matrices, 0)
	M:rotateZ(matrices, 0)
	M:rotateX(matrices, 140)

	M:scale(matrices, 1.1, 1.1, 1.1)
end

-- Diamond

if I:isOf(item, Items:get("minecraft:diamond")) then
    M:moveY(matrices, 0.2)
    M:moveZ(matrices, 0.1) 
    M:moveX(matrices, 0) 

    M:rotateY(matrices, 93 * l)
    M:rotateX(matrices, -50)
    M:rotateZ(matrices, -30 * l)
    M:scale(matrices, 1.3, 1.3, 1.3)
end
end
