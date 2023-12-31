package personal.ibonny.mo_remix.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import personal.ibonny.mo_remix.MORemix;
import personal.ibonny.mo_remix.block.machines.*;
import personal.ibonny.mo_remix.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MORemix.MOD_ID);

    /* Machines */
    public static final RegistryObject<Block> MATTER_ANALYZER = registerBlock("matter_analyzer",
            () -> new BlockMatterAnalyzer(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> PATTERN_STORAGE = registerBlock("pattern_storage",
            () -> new BlockPatternStorage(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> MICROWAVE = registerBlock("microwave",
            () -> new BlockMicrowave(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> REPLICATOR = registerBlock("new_replicator",
            () -> new BlockReplicator(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> TRITANIUM_ORE = registerBlock("tritanium_ore",
            () -> new BlockTritaniumOre(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> MATTER_DECOMPOSER = registerBlock("matter_decomposer",
            () -> new BlockMatterDecomposer(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> HOLO_MATTER_SIGN = registerBlock("holo_matter_sign",
            () -> new BlockHoloMatterSign(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()));

    /* Decorative blocks */
    public static final RegistryObject<Block> TRITANIUM_PLATE_STRIPES = registerBlock("tritanium_plate_stripes",
            () -> new MOPillarBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> TRITANIUM_PLATE = registerBlock("tritanium_plate",
            () -> new MOPillarBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> BEAMS = registerBlock("beams",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> VENT_BRIGHT = registerBlock("vent_bright",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> FLOOR_TILES = registerBlock("floor_tiles",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> CARBON_FIBER_PLATE = registerBlock("carbon_fiber_plate",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> CLEAN = registerBlock("clean",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> COILS = registerBlock("coils",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> HOLO_SIGN = registerBlock("holo_sign",
            () -> new BlockHoloMatterSign(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()));

    /* Helper methods */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        RegistryObject<Item> toReturn = ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));

        return toReturn;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
