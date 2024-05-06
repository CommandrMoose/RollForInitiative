package river.rollforinitiative.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;
import river.rollforinitiative.common.blockentity.EncounterManagerBlockEntity;

public class EncounterManagerBlock extends BaseEntityBlock {
    public EncounterManagerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new EncounterManagerBlockEntity(blockPos, blockState);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {

        if (interactionHand == InteractionHand.MAIN_HAND) {
            if (level.getBlockEntity(blockPos) instanceof EncounterManagerBlockEntity blockEntity) {
                blockEntity.onInteracted(level, player, player.getItemInHand(interactionHand), false);
            }
        }

        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }
}
