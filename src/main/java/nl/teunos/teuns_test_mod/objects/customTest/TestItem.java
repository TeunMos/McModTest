package nl.teunos.teuns_test_mod.objects.customTest;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class TestItem extends Item {
    public TestItem(Properties properties) {
        super(properties);
    }
    
    
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        if (player == null) {
            return InteractionResult.FAIL;
        }

        if(!context.getLevel().isClientSide) {
            BlockPos pos = context.getClickedPos();


            for (int i = 0; i <= pos.getY() + 64; i++) {
                BlockState state = context.getLevel().getBlockState(pos.below(i));

                if (isValueableBlock(state)) {
                    outputValueableBlock(pos.below(i), player, state.getBlock());

                    return InteractionResult.SUCCESS;
                }
            }

            player.sendSystemMessage(
                Component.literal("No valueable blocks found")
            );
        }

        context.getItemInHand().hurtAndBreak(1, 
            player,
            EquipmentSlot.MAINHAND
        );


        return InteractionResult.SUCCESS;
    }


    private void outputValueableBlock(BlockPos below, Player player, Block block) {
        player.sendSystemMessage(
            Component.literal(
                "Found " + block.getName().getString() + " at " + below.getX() + ", " + below.getY() + ", " + below.getZ()
            )
        );
    }


    private boolean isValueableBlock(BlockState state) {
        return state.is(Blocks.IRON_ORE);
    }

}
