// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake.IntakeSubsystem;

public class autoIntake extends Command {
  IntakeSubsystem m_IntakeSubsystem;
  Timer timer;
  /** Creates a new AutonIntake. */
  public autoIntake(IntakeSubsystem Intake) {
    this.m_IntakeSubsystem = Intake;
    timer = new Timer();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_IntakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    System.out.print("In Intake Exec before+++++++++++++ ");
    m_IntakeSubsystem.autonRunIntake(3);
    System.out.print("In Intake Exec after----------------- ");

  }

  // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//   //debugging statement to see if this is being executed
//     System.out.print("In Intake Exec before+++++++++++++ ");
// //    m_IntakeSubsystem.intakeRight.set(3);
//     m_IntakeSubsystem.runIntake(3);
//     System.out.print("In Intake Exec after----------------- ");
//   }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.print("In Intake Exec END+++++++");
    m_IntakeSubsystem.autonStopIntake();
    timer.stop(); 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (timer.get() > 2.5){
      System.out.print("In Intake Isfinished Time>>>>><<<<<");
      return true;

    }
    else {
      return false;
    }
  }
}
