package net.keeblekapa.eldritchrealms.item;

import net.keeblekapa.eldritchrealms.EldritchRealms;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum EldritchRealmsArmorMaterials implements ArmorMaterial {
        SHADOWSTEEL("shadowsteel", 42, new int[] {11, 16, 15, 13}, 18,
                SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2f, 0.05f, () -> Ingredient.ofItems(EldritchRealmsItems.SHADOWSTEEL_INGOT)),

        ENIGMATIC_IRON("enigmatic_iron", 38, new int[] {9, 14, 12, 11}, 18,
                SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.75f, 0.025f, () -> Ingredient.ofItems(EldritchRealmsItems.ENIGMATIC_IRON_INGOT)),

        HALLOW_GOLD("hallow_gold", 32, new int[] {7, 12, 10, 9}, 26,
                SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0, 0, () -> Ingredient.ofItems(EldritchRealmsItems.HALLOW_GOLD_INGOT))
    ;


    private final String name;
    private final int durabilityMultiplier;
    private final int enchantability;
    private final int[] protectionAmounts;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 15, 13 };

    EldritchRealmsArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound,
                                 float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.enchantability = enchantability;
        this.protectionAmounts = protectionAmounts;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return EldritchRealms.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
