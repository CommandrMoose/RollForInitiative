package river.rollforinitiative.common.item;

import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import river.rollforinitiative.common.block.EncounterManagerBlock;
import river.rollforinitiative.common.blockentity.EncounterManagerBlockEntity;
import river.rollforinitiative.contants.RFILocalization;
import river.rollforinitiative.util.PlayerUtil;

public class GameMasterScreenItem extends Item {
    public GameMasterScreenItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {

        ItemStack item = player.getItemInHand(interactionHand);
        CompoundTag tag = item.getOrCreateTag();
        CompoundTag blockPos = tag.getCompound("target_block");
        if (!blockPos.isEmpty()) {
            BlockPos targetPos = NbtUtils.readBlockPos(blockPos);
            if (level.getBlockEntity(targetPos) instanceof EncounterManagerBlockEntity encounterManagerBlockEntity) {
                encounterManagerBlockEntity.onInteracted(level, player, item, true);
            }
        }


        return super.use(level, player, interactionHand);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {

        BlockPos clickedPos = useOnContext.getClickedPos();

        if (useOnContext.getLevel().getBlockState(clickedPos).getBlock() instanceof EncounterManagerBlock block) {
            ItemStack stack = useOnContext.getItemInHand();
            setEncounterItem(stack, clickedPos);
            PlayerUtil.sendMessage(useOnContext.getPlayer(), Component.translatable(RFILocalization.ENCOUNTER_LINKED), true);
            useOnContext.getLevel().playSound(useOnContext.getPlayer(), clickedPos, SoundEvents.STONE_BUTTON_CLICK_ON, SoundSource.BLOCKS, 1f, 1f);

        }

        return super.useOn(useOnContext);
    }

    private void setEncounterItem(ItemStack stack, BlockPos newPosition) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.put("target_block", NbtUtils.writeBlockPos(newPosition));
        stack.setTag(tag);


    }
}
