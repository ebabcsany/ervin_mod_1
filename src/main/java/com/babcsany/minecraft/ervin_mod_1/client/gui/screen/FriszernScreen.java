package com.babcsany.minecraft.ervin_mod_1.client.gui.screen;

import com.babcsany.minecraft.ervin_mod_1.block.FriszernLogic;
import com.babcsany.minecraft.ervin_mod_1.block.FriszernTileEntity;
import com.babcsany.minecraft.ervin_mod_1.network.play.CUpdateFriszernPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FriszernScreen extends AbstractFriszernScreen {
   private final FriszernTileEntity friszern;
   private Button modeBtn;
   private Button conditionalBtn;
   private Button autoExecBtn;
   private FriszernTileEntity.Mode commandBlockMode = FriszernTileEntity.Mode.REDSTONE;
   private boolean conditional;
   private boolean automatic;

   public FriszernScreen(FriszernTileEntity commandBlockIn) {
      this.friszern = commandBlockIn;
   }

   FriszernLogic getLogic() {
      return this.friszern.getLogic();
   }

   int func_195236_i() {
      return 135;
   }

   protected void init() {
      super.init();
      this.modeBtn = this.addButton(new Button(this.width / 2 - 50 - 100 - 4, 165, 100, 20, new TranslationTextComponent("advMode.mode.sequence"), (p_214191_1_) -> {
         this.nextMode();
         this.updateMode();
      }));
      this.conditionalBtn = this.addButton(new Button(this.width / 2 - 50, 165, 100, 20, new TranslationTextComponent("advMode.mode.unconditional"), (p_214190_1_) -> {
         this.conditional = !this.conditional;
         this.updateConditional();
      }));
      this.autoExecBtn = this.addButton(new Button(this.width / 2 + 50 + 4, 165, 100, 20, new TranslationTextComponent("advMode.mode.redstoneTriggered"), (p_214189_1_) -> {
         this.automatic = !this.automatic;
         this.updateAutoExec();
      }));
      this.doneButton.active = false;
      this.trackOutputButton.active = false;
      this.modeBtn.active = false;
      this.conditionalBtn.active = false;
      this.autoExecBtn.active = false;
   }

   public void updateGui() {
      FriszernLogic friszernLogic = this.friszern.getLogic();
      this.commandTextField.setText(friszernLogic.getCommand());
      this.trackOutput = friszernLogic.shouldTrackOutput();
      this.commandBlockMode = this.friszern.getFriszernMode();
      this.conditional = this.friszern.isConditional1();
      this.automatic = this.friszern.isAuto();
      this.updateTrackOutput();
      this.updateMode();
      this.updateConditional();
      this.updateAutoExec();
      this.doneButton.active = true;
      this.trackOutputButton.active = true;
      this.modeBtn.active = true;
      this.conditionalBtn.active = true;
      this.autoExecBtn.active = true;
   }

   public void resize(Minecraft minecraft, int width, int height) {
      super.resize(minecraft, width, height);
      this.updateTrackOutput();
      this.updateMode();
      this.updateConditional();
      this.updateAutoExec();
      this.doneButton.active = true;
      this.trackOutputButton.active = true;
      this.modeBtn.active = true;
      this.conditionalBtn.active = true;
      this.autoExecBtn.active = true;
   }

   protected void func_195235_a(FriszernLogic friszernLogicIn) {
      this.minecraft.getConnection().sendPacket(new CUpdateFriszernPacket(new BlockPos(friszernLogicIn.getPositionVector()), this.commandTextField.getText(), this.commandBlockMode, friszernLogicIn.shouldTrackOutput(), this.conditional, this.automatic));
   }

   private void updateMode() {
      switch(this.commandBlockMode) {
      case SEQUENCE:
         this.modeBtn.setMessage(new TranslationTextComponent("advMode.mode.sequence"));
         break;
      case AUTO:
         this.modeBtn.setMessage(new TranslationTextComponent("advMode.mode.auto"));
         break;
      case REDSTONE:
         this.modeBtn.setMessage(new TranslationTextComponent("advMode.mode.redstone"));
      }

   }

   private void nextMode() {
      switch(this.commandBlockMode) {
      case SEQUENCE:
         this.commandBlockMode = FriszernTileEntity.Mode.AUTO;
         break;
      case AUTO:
         this.commandBlockMode = FriszernTileEntity.Mode.REDSTONE;
         break;
      case REDSTONE:
         this.commandBlockMode = FriszernTileEntity.Mode.SEQUENCE;
      }

   }

   private void updateConditional() {
      if (this.conditional) {
         this.conditionalBtn.setMessage(new TranslationTextComponent("advMode.mode.conditional"));
      } else {
         this.conditionalBtn.setMessage(new TranslationTextComponent("advMode.mode.unconditional"));
      }

   }

   private void updateAutoExec() {
      if (this.automatic) {
         this.autoExecBtn.setMessage(new TranslationTextComponent("advMode.mode.autoexec.bat"));
      } else {
         this.autoExecBtn.setMessage(new TranslationTextComponent("advMode.mode.redstoneTriggered"));
      }

   }
}