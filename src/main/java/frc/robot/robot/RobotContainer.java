// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.*;
import static frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public Drivetrain drivetrain  = new Drivetrain();
  public final Joystick joy = new Joystick(0);
  public Hammer hammer = new Hammer();
  public Head head = new Head();



  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(joy, BUTTONX).whileHeld(new InstantCommand(head::headSpinClockwise)).whenReleased(new InstantCommand(head::headStop));
    new JoystickButton(joy, BUTTONB).whileHeld(new InstantCommand(head::headSpinCounterClockwise)).whenReleased(new InstantCommand(head::headStop));
    new JoystickButton(joy, BUTTONY).whenPressed(new InstantCommand(hammer::hammerSpin));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  public void setDriveDefault()
  {
    drivetrain.setDefaultCommand(new driveDefaultCommand(drivetrain, joy).perpetually());
  }

   static class driveDefaultCommand extends CommandBase 
   {
    Drivetrain drivetrain;
    Joystick joystick;

    public driveDefaultCommand(Drivetrain drivetrain, Joystick joystick) 
    {
        addRequirements(drivetrain);
        this.drivetrain = drivetrain;
        this.joystick = joystick;
    }

    @Override
    public void execute() 
    {
      drivetrain.drive(joystick.getZ(), joystick.getY());
    }
   }


  //public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
  //}
}
