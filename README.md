# Instagram-Like-Bot

How The Bot Works:

This Bot is not completely finished yet because of some bugs but as of now it works to a ceratin degree.
Basically this bot logs into the Instagram Account in which you wish to turn into a bot, then redirects to the activity feed.
The bot then refreshes the page every five seconds waiting for someone to follow.
Once someone follows the account it checks if the account is private. If the account is privates it requests to follow the account.
However I have not implemented a check to see if the private user has any posts before following so I plan on implementing that.
If the bot's request is accepted before fifteen seconds it then finds the href in which the picture is located then navigates to that link.
After the bot navigates to the first photo it clicks the like button then navigates back to the users base account.
Then depending on the users posts iterates through their posts liking all their photos using xpaths.
Then blocks the user and unblocks them then navigates to their activity feed.
The whole point of doing this is to clear the activity feed without destroying the likes given. 
This creates a queue allowing constant operation of the program.


Contact me at: nolsweeney0@gmail.com
