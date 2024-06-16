package nl.teunos.teuns_test_mod.objects.customTest;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import nl.teunos.teuns_test_mod.teuns_test_mod;

public class TestTags {
    public static class Blocks {
        public static final TagKey<Block> POOPABLES = tag("poopables");

        private static TagKey<Block> tag(String name) { 
            return BlockTags.create(new ResourceLocation(teuns_test_mod.MODID, name));
        }
    }

    public static class Items {

    }
}
