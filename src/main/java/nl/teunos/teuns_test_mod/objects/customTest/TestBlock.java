package nl.teunos.teuns_test_mod.objects.customTest;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class TestBlock extends Block {
    public TestBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level,
            BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {

        InteractionResult result = use(blockState, level, blockPos, player, blockHitResult);
        if (result == InteractionResult.SUCCESS) {
            return ItemInteractionResult.SUCCESS;
        }
        else {
            return ItemInteractionResult.FAIL;
        }
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState blockState, Level level,
    BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        return use(blockState, level, blockPos, player, blockHitResult);
    }


    
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        level.playSound(player, blockPos, SoundEvents.SLIME_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);

        return InteractionResult.SUCCESS;
    }
}
