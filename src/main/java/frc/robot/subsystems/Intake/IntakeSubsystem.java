package frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.lang.reflect.Method;
import java.util.function.DoubleSupplier;

//import com.revrobotics.*;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkMax;

public class IntakeSubsystem extends SubsystemBase {
    private final CANSparkMax intakeRight; // Right Joystick
    //private final ConvSubsystem m_conv = new ConvSubsystem();

    public IntakeSubsystem() {
        intakeRight = new CANSparkMax(15, MotorType.kBrushless);

        intakeRight.restoreFactoryDefaults();
        intakeRight.setIdleMode(IdleMode.kCoast);
    }
    /* Intake still not on Joysticks
    // public void changeAngle(double liftPower) {
    //     intakeLeft.set(liftPower);
    // }

    // public Command runManual(DoubleSupplier supplier){
    //     double power = supplier.getAsDouble();
    //     return run(() -> {
    //         changeAngle(power);
    //     });
    // }
    // public void setLeftMan(double liftPower) {
    //     intakeLeft.set(liftPower);
    // }
     */

    public Command runRightIntake(Double supplier){
        //double speed = supplier.getAsDouble();
        return run(()-> {
            intakeRight.set(supplier);
        });
    }
    public Command runLeftIntake(DoubleSupplier supplier){
        double power = supplier.getAsDouble();
        return run(() -> {
            intakeRight.set(power);
        });
    }

    public Command stopRightIntake(){
        return run(
            () -> intakeRight.stopMotor()
        );
    }

    public Command stopLeftIntake(){
        return runOnce(
            () -> intakeRight.stopMotor()
        );
    }

     public Command runIntake(double speed){
         return this.run(() -> {
             
             intakeRight.set(speed);
         });
     }

     public Command autoRunIntake(){
        return startEnd(
            () -> intakeRight.set(3),
            () -> intakeRight.stopMotor()
        );
    }




    public Command stopIntake(){
         return this.runOnce(() -> {
             intakeRight.set(0);
             intakeRight.set(0);
         });
     }


     public Command autoRunIntakeRevers(){
        return startEnd(
            () -> intakeRight.set(-.85),
            () -> intakeRight.stopMotor()
        );
    }



    // Auto Methods below ------------------------


    // public Command stopIntake(){
    //     return this.runOnce(() -> {
    //         intakeRight.set(0);
    //         intakeRight.set(0);
    //     });
    // }
    
    // public void autoRunIntake(){
    
    //         () -> intakeRight.set(3);
    //         () -> intakeRight.stopMotor();
        
    // }

    // public void autoRunIntakeRevers(){
    
    //         () -> intakeRight.set(-.85),
    //         () -> intakeRight.stopMotor()
        
    // }

    // public Command runIntake(double speed){
    //     return this.run(() -> {
    //         
    //         intakeRight.set(speed);
    //     });
    // }
    
    public void autonRunIntake(double speed){
        
            System.out.print("************In Intake SubSytem***********");
            intakeRight.set(speed);
        
    }

    public void autonStopIntake(){
        
            intakeRight.set(0);
            intakeRight.set(0);
      
    }


    @Override
    public void periodic(){}
}