*How to Run*
Using Terminal, type the command "Gradle Run"


This is a Platformer interactive Game designed to allow character to move around the level 
and interact with platforms, jump, move left and right, interact with different types of enemies
with different behaviours.

Some characteristics of the character can be eddited and changed via Json file "default.Json" 
located in src\main\resources. Characteristics include

Character Size:
This configuration should be next to   "stickmanSize": (here) , where the valid inputs are:
	- "Tiny"
	- "Normal"
	- "Large"
	- "Giant"
This determins the Size of the character that will be printed onto the screen

Character Initial Location
This can be edited inside "stickmanPos: {"x": (here) } where you will be able to edit
the initial Xvalue of the character. The valid inputs are values between 50.0~200.0.
This has to be of value double therefore YOU NEED TO PUT A DECIMAL PLACE

Cloud Velocity
This is a configuration for the speed of the Cloud entity inside the game, 
This can be configured in section "cloudVelocity": (here) section of Json file where 
the valid input values are between 1.0~5.0 inclusively, Therefore 1.0 to 5.0.
This has to be of value double therefore YOU NEED TO PUT A DECIMAL PLACE

Level Type
This configuration changes the nature of the Level onto the character. 
The choices can be between:
	Normal:
		This is a default type where there is no effect or changes to background.
	Windy:
		This is a Level that makes it so the cloud goes backwards due to Wind.
		Character gets pushed back because of a Windy environment.
	Ice:
		This makes the floor "slippery" making the character's movement of left and right
		result in drifting when stopped moving;

Any alteration of this setting will result in Error Window to pop up forcing you to end the 
game and edit the Json file.