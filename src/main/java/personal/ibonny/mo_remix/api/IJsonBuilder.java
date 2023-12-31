package personal.ibonny.mo_remix.api;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Map;

public interface IJsonBuilder {
    Map<String, String> getVariants(); // condition, model
    String getItemParent(); // parent for the item

    String getModelParent(); // parent for the model.

    Map<String, String> getModelTextures(); // side, texture

    Map<String, Pair<int[], double[]>> getDisplay(); // type, rotation, scale

    boolean addBlockItem();
}
