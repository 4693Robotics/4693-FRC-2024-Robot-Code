package frc.robot.Commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class ShootIntakeAmp extends Command {
        
    IntakeSubsystem intakesystem;
    PIDController armPIDController;
    Timer timer;

    public ShootIntakeAmp(IntakeSubsystem IntakeSubsystem) {
        this.intakesystem = IntakeSubsystem;
        this.timer = new Timer();

        addRequirements(IntakeSubsystem);
    }

    public void initialize() {
        timer.reset();
        timer.start();
        intakesystem.setIntakeArmSpeed(0.2);
    }

    @Override
    public void execute() {
        if (timer.get() > 0.36) {
            intakesystem.setIntakeRollerSpeed(-1);
        }
        if (timer.get() > 0.4) {
            intakesystem.setIntakeArmSpeed(0);
        }
    }

    @Override
    public void end(boolean interrupted) {
     timer.stop();
     intakesystem.setIntakeArmSpeed(0);
     intakesystem.setIntakeRollerSpeed(0);
    }

    @Override
    public boolean isFinished() {
      return timer.get() > 0.7;
    }
}
