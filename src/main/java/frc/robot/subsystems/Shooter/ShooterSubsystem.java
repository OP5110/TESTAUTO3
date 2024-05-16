package frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//import com.revrobotics.*;
import com.revrobotics.CANSparkLowLevel.MotorType;
//import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkMax;

public class ShooterSubsystem extends SubsystemBase {
    private final CANSparkMax shooterMotor;
    private final CANSparkMax shooterMotor2;
    public ShooterSubsystem() {
        shooterMotor = new CANSparkMax(16, MotorType.kBrushless);
        shooterMotor2 = new CANSparkMax(17, MotorType.kBrushless);
        shooterMotor.restoreFactoryDefaults();
        shooterMotor2.restoreFactoryDefaults();

       // shooterMotor.setIdleMode(IdleMode.kBrake);
    }

    public Command runShooter(double speed){
        return this.runOnce(() -> {
            shooterMotor.set(speed);
            shooterMotor2.set(speed);
        });
    }

// Auto


public void autonrunShooter(double speed){
    System.out.print("In Shooter sub");
        shooterMotor.set(speed);
        shooterMotor2.set(speed);
    
}

public void autonstopShooter(){

        shooterMotor.set(0);
        shooterMotor2.set(0);
   
}

    public Command stopShooter(){
        return this.runOnce(() -> {
            shooterMotor.set(0);
            shooterMotor2.set(0);
        });
    }

     public Command autoShooterRunv1(){
        return new InstantCommand(
            () -> {
                shooterMotor.set(-.85);
                shooterMotor2.set(-.85);
            });
    }
         public Command autoShooterRunv2(){
        return new InstantCommand(
            () -> {
                shooterMotor.set(-.85);
                shooterMotor2.set(-.85);
            });
    }
}

