package frc.robot.Commands.Auto;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeInAuto extends Command {

    IntakeSubsystem intakesystem;
    PIDController armPIDController;
    Timer timer;

    double intakeRollerSpeed;
    double armPosition;


    public IntakeInAuto(IntakeSubsystem IntakeSubsystem) {
        this.intakesystem = IntakeSubsystem;
        this.timer = new Timer();

        addRequirements(IntakeSubsystem);
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
        intakesystem.setIntakeArmSpeed(-0.2);
        intakesystem.setIntakeRollerSpeed(0);
    }

    @Override
    public void execute() {
        if (timer.get() > 0.75) {
            intakesystem.setIntakeArmSpeed(0);
        }
    }

    @Override
    public void end(boolean interrupted) {
     timer.stop();
     intakesystem.setIntakeArmSpeed(0);
     intakesystem.setIsIntakeUp(true);
    }

    @Override
    public boolean isFinished() {
      return timer.get() > 0.9;
    }
}
