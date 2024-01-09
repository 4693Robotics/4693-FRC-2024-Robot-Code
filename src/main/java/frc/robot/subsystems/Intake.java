// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {

    private final CANSparkMax m_intakeMotor = new CANSparkMax(IntakeConstants.kIntakeCanId, MotorType.kBrushless);

    public Intake() {

    }

    public void intakeStart(double speed) {
        m_intakeMotor.set(speed);
    }

    public void intakeForward() {
        m_intakeMotor.set(1);
    }

    public void intakeBackwards() {
        m_intakeMotor.set(-1);
    }
}
