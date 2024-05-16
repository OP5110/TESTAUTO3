// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ShooterCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter.ShooterSubsystem;

public class autoShooter extends Command {
  ShooterSubsystem m_ShooterSubsystem;
  Timer timer;

  // Timer
  /** Creates a new AutoShoot. */
  public autoShooter(ShooterSubsystem shooterSubsystem) {
    this.m_ShooterSubsystem = shooterSubsystem;
    timer = new Timer();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_ShooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    System.out.print("In Shooter Exec ");
    m_ShooterSubsystem.autonrunShooter(-1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  // @Override
  // public void execute() {

  //   //debugging statement to see if this is being executed
  //   System.out.print("In Shooter Exec ");
 
  //   m_ShooterSubsystem.runShooter(-1);
  // }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_ShooterSubsystem.autonstopShooter();
    System.out.print("In Shooter Exec END+++++++");
    timer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (timer.get() > 2) {
      System.out.print("In Shooter Isfinished Time");
      return true; //causes the command to end if the timer is greater than 2 seconds
    }
    else {
      return false; //if the timer is not greater than 2 seconds, the command will not end
    }
     //when thes value is true, the scheduler runs the command once and then ends the command
  }
}
