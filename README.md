# Wish Simulator by Treyson Le

## About

  Hey! I've been pretty obsessed with Gacha games like Genshin and Honkai: Star Rail. 
  
  A Gacha game is defined as:<br />
  * A video game that implements the gachapon machine style mechanics. Similar to loot boxes, gacha games entice players to spend in-game currency to receive a random in-game item.

  These games have such a chokehold over me that I decided to code the system on my own. Looking to transition this project into more, but it helps to have a baseline I believe. 
  Looking for help and advice!

  Please reach out if you have questions, and thanks!
 
  -Trey

## How to Run
  You can just run it using the Main method. Easy Peasy.<br />
  There is a text file with the list of rewards. Feel free to edit it!

## Future Goals
  * Create web user interface (Frontend)<br />
  * Adapt to other potential things (popmart)<br />

## Goals (currently implemented, seeking improvements)
### Currency System
  * To have a “currency” that gets used and lets you roll (Want it to mimic Money)<br />
  * Check if has token<br />
  * When no tokens, prompt method to get tokens<br />
  * If has token, take it away <br />
  * Have option to take 1 or take 10 tokens<br />
  * Create method that will refill tokens<br />
  * Track Total amount of money spent to get tokens <br />
  
### Roll System
  * When token is spent, activate system<br />
  * Guaranteed to give “prize”<br />
    * Develop Prize System<br />
      * 3 Forms of Prizes with progressive rarities (Low, Mid, High)<br />
      * Set probability with getting each rarity<br />
      * Save history of prizes (amount and rarity)<br />
    * Roll History System:<br />
      * After Roll is done, save the data (as counter or data)<br />
        * Data must be saved and used to calculate future rolls<br />
        * Add different prizes in rarity at later date<br />
    * Pity System<br />
      * Very Low chance to get high rarity<br />
      * Low chance to get mid rarity<br />
      * If not high or mid, it’s low rarity<br />
      * Use Roll History to determine pity<br />
        * Hard Pity System: (genshing odds vs hsr odds?)<br />
          * Every 80/90th roll is guaranteed high rarity<br />
          * Develop 50/50 system<br />
          * 50% to get desired item<br />
          * 50% to not get item<br />
            * If “lose 50/50”, next high rarity is guaranteed to be what you want<br />
        * If received high rarity:<br />
          * Run 50/50 system<br />
          * Reset Hard Pity<br />
        * Soft Pity System:<br />
          * After 75 Rolls, Odds to receive high rarity increase<br />
          * Reset after receiving high rarity<br />
        * Mid Pity System:<br />
          * Every 10th roll is guaranteed a mid rarity<br />
          * Resets after receiving mid rarity, even if received early <br />
  * Allow importing a list of rewards<br />


