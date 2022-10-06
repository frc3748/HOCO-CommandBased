package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;
import edu.wpi.first.wpilibj.Joystick;

public class Head {
    private TalonSRX head;

    public Head(){
        head = new TalonSRX(13); //forgot the which motor it was
    }

    public void headSpinClockwise(){
        head.set(ControlMode.PercentOutput, 0.75);
        System.out.println("head spin");
    }

    public void headSpinCounterClockwise(){
        head.set(ControlMode.PercentOutput, -0.75);
        System.out.println("head spin");
    }

    public void headStop(){
        head.set(ControlMode.PercentOutput, 0);
        System.out.println("head stop");
    }
}
