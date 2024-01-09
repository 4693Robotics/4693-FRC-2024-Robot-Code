// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {

    private final CANSparkMax m_intakePowerMotor = new CANSparkMax(IntakeConstants.kIntakePowerCanId, MotorType.kBrushless);
    private final CANSparkMax m_intakePositionMotor = new CANSparkMax(IntakeConstants.kIntakePositionCanId, MotorType.kBrushless);
    private final RelativeEncoder m_intakePositionEncoder = m_intakePositionMotor.getEncoder();

    public void periodic() {
        double IntakePosition = m_intakePositionEncoder.getPosition();
    }

    public Intake() {

    }

    public void intakeStart(double speed) {
        m_intakePowerMotor.set(speed);
    }

    public void intakeForward() {
        m_intakePowerMotor.set(1);
    }

    public void intakeBackwards() {
        m_intakePowerMotor.set(-1);
    }

    public void intakeUp() {
        m_intakePositionMotor.set(1);
    }

    public void intakeDown() {
        m_intakePositionMotor.set(-1);
    }
}
