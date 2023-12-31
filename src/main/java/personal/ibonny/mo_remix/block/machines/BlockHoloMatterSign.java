package personal.ibonny.mo_remix.block.machines;

import org.apache.commons.lang3.tuple.Pair;
import personal.ibonny.mo_remix.api.IJsonBuilder;
import personal.ibonny.mo_remix.block.MOBaseBlock;
import personal.ibonny.mo_remix.entities.BlockHoloMatterSignEntity;

import java.util.Map;

public class BlockHoloMatterSign extends MOBaseBlock implements IJsonBuilder {
    public BlockHoloMatterSign(Properties properties) {
        super(properties, BlockHoloMatterSignEntity::new);
    }

    @Override
    public Map<String, String> getVariants() {
        return Map.of(
            "facing=north", "mo_remix:block/holo_matter_sign",
            "facing=south", "mo_remix:block/holo_matter_sign,y=180",
            "facing=west", "mo_remix:block/holo_matter_sign,y=270",
            "facing=east", "mo_remix:block/holo_matter_sign,y=90"
        );
    }

    @Override
    public String getItemParent() {
        return "mo_remix:block/holo_matter_sign";
    }

    @Override
    public String getModelParent() {
        return null;
    }

    @Override
    public Map<String, String> getModelTextures() {
        return null;
    }

    @Override
    public Map<String, Pair<int[], double[]>> getDisplay() {
        return Map.of(
            "thirdperson_righthand", Pair.of(new int[]{0, 159, 0}, new double[]{0.4, 0.4, 0.4}),
            "thirdperson_lefthand", Pair.of(new int[]{0, 159, 0}, new double[]{0.4, 0.4, 0.4}),
            "gui", Pair.of(new int[]{0, 159, 0}, new double[]{0.4, 0.4, 0.4})
        );
    }

    @Override
    public boolean addBlockItem() {
        return true;
    }
}
