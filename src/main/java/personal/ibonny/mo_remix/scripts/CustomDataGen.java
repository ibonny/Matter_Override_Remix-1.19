package personal.ibonny.mo_remix.scripts;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;

import static personal.ibonny.mo_remix.block.ModBlocks.BLOCKS;

public class CustomDataGen {
    public static void main(String[] args) {
        Collection<RegistryObject<Block>> ourBlocks = BLOCKS.getEntries();

        for(RegistryObject<Block> block: ourBlocks) {
            System.out.println("Name: " + block);
        }
    }
}
