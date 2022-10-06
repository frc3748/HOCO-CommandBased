package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;
import edu.wpi.first.wpilibj.Joystick;

public class Hammer {
    private TalonSRX hammer;

    public Hammer(){
        hammer = new TalonSRX(17); //forgot the which motor it was
    }
//r
    public void hammerSpin(){
        hammer.set(ControlMode.PercentOutput, 0.15);
        System.out.println("hammer spin");
    }

    public void hammerStop(){
        hammer.set(ControlMode.PercentOutput, 0);
        System.out.println("hammer spin");
    }
}

    

