package com.corgam.cagedmobs.serializers.mob;

import com.corgam.cagedmobs.CagedMobs;
import com.corgam.cagedmobs.serializers.RecipesHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.List;

public class AdditionalLootData implements Recipe<Inventory> {

    private final ResourceLocation id;
    private EntityType<?> entityType;
    private final List<LootData> results;

    public AdditionalLootData(ResourceLocation id, EntityType<?> entityType, List<LootData> results){
        this.id = id;
        this.entityType = entityType;
        this.results = results;
        // Add the id to the list of loaded recipes
        if(id != null && CagedMobs.LOGGER != null){
            CagedMobs.LOGGER.info("Loaded AdditionalLootData recipe with id: " + id.toString());
        }
    }

    @Override
    public boolean matches(Inventory inv, Level worldIn) {
        return false;
    }

    @Override
    public ItemStack assemble(Inventory inv) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getResultItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return AdditionalLootDataSerializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return RecipesHelper.ADDITIONAL_LOOT_RECIPE;
    }

    public List<LootData> getResults () {
        return this.results;
    }

    public EntityType<?> getEntityType(){
        return this.entityType;
    }

    public void setEntityType(EntityType<?> entityType){
        this.entityType = entityType;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}
