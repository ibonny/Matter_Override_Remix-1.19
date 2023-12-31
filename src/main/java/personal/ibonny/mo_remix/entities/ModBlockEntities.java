package personal.ibonny.mo_remix.entities;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import personal.ibonny.mo_remix.MORemix;
import personal.ibonny.mo_remix.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MORemix.MOD_ID);

    public static final RegistryObject<BlockEntityType<BlockMatterAnalyzerEntity>> MATTER_ANALYZER =
            BLOCK_ENTITIES.register("matter_analyzer_entity", () ->
                BlockEntityType.Builder.of(BlockMatterAnalyzerEntity::new,
                        ModBlocks.MATTER_ANALYZER.get()).build(null));

    public static final RegistryObject<BlockEntityType<BlockPatternStorageEntity>> PATTERN_STORAGE =
            BLOCK_ENTITIES.register("pattern_storage_entity", () ->
                BlockEntityType.Builder.of(BlockPatternStorageEntity::new,
                        ModBlocks.PATTERN_STORAGE.get()).build(null));

    public static final RegistryObject<BlockEntityType<BlockMicrowaveEntity>> MICROWAVE =
            BLOCK_ENTITIES.register("microwave_entity", () ->
                    BlockEntityType.Builder.of(BlockMicrowaveEntity::new,
                            ModBlocks.MICROWAVE.get()).build(null));

    public static final RegistryObject<BlockEntityType<BlockReplicatorEntity>> REPLICATOR =
            BLOCK_ENTITIES.register("new_replicator", () ->
                    BlockEntityType.Builder.of(BlockReplicatorEntity::new,
                            ModBlocks.REPLICATOR.get()).build(null));

    public static final RegistryObject<BlockEntityType<BlockMatterDecomposerEntity>> MATTER_DECOMPOSER =
            BLOCK_ENTITIES.register("matter_decomposer", () ->
                    BlockEntityType.Builder.of(BlockMatterDecomposerEntity::new,
                            ModBlocks.MATTER_DECOMPOSER.get()).build(null));

    public static final RegistryObject<BlockEntityType<BlockMatterDecomposerEntity>> HOLO_MATTER_SIGN =
            BLOCK_ENTITIES.register("holo_matter_sign", () ->
                    BlockEntityType.Builder.of(BlockMatterDecomposerEntity::new,
                            ModBlocks.HOLO_MATTER_SIGN.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
