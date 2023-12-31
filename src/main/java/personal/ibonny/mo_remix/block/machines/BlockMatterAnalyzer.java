package personal.ibonny.mo_remix.block.machines;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import personal.ibonny.mo_remix.block.MOBaseBlock;
import personal.ibonny.mo_remix.entities.BlockMatterAnalyzerEntity;
import personal.ibonny.mo_remix.entities.ModBlockEntities;

import java.util.List;

public class BlockMatterAnalyzer extends MOBaseBlock {
    private static final BooleanProperty RUNNING = BooleanProperty.create("running");

    public BlockMatterAnalyzer(Properties properties) {
        super(properties, BlockMatterAnalyzerEntity::new);

        this.registerDefaultState(this.stateDefinition.any()
                .setValue(RUNNING, false)
        );
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter level, @NotNull List<Component> componets, @NotNull TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            componets.add(Component.literal("This is the matter analyzer.").withStyle(ChatFormatting.AQUA));
        } else {
            componets.add(Component.literal("Press SHIFT for more info.").withStyle(ChatFormatting.YELLOW));
        }

        super.appendHoverText(stack, level, componets, flag);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);

        builder.add(RUNNING);
    }

    /* BLOCK ENTITY */

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof BlockMatterAnalyzerEntity) {
                ((BlockMatterAnalyzerEntity) blockEntity).drops();
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }

    @Override
    @Deprecated
    public InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos,
                                 @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        if (!level.isClientSide()) {
            BlockEntity entity = level.getBlockEntity(pos);
            if(entity instanceof BlockMatterAnalyzerEntity) {
                NetworkHooks.openScreen(((ServerPlayer) player), (BlockMatterAnalyzerEntity) entity, pos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.MATTER_ANALYZER.get(),
                BlockMatterAnalyzerEntity::tick);
    }
}
