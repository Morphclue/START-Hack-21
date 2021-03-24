# START-Hack-21
START Hack 2021 is a event hosted by students of the University of St. Gallen. This 36-hour Hackathon provided a lot of opportunities to learn about new stuff.

## Team FeatureFox
Our Team consisted of 4 members:
* [Julian](https://github.com/distrustME)
* [Nils](https://github.com/Schoene1)
* [Steffen](https://github.com/SteffenKr)
* [Torben](https://github.com/TRBN93)

## Case
[Helsana](https://www.helsana.ch/) provided a cool challenge for our team. The topic was `Make Switzerland fitter`. 
You can see the case pitch on the following [repository](https://github.com/START-Global/Helsana-STARTHACK21).

## Basic Idea
We tried to identify the main problems and thought about how to display them easy for a user.
| Problem  | Solution |
| ------------- | ------------- |
| Multiple Apps | One App for everything |
| Complex Design | Simple design for every user |
| Complex data | Make data uniform and easy to use |
| Motivation | Motivate the user with positive suggestions |
| Motivation | Motivate the user by allowing him to challenge friends |
| Data protection | Share a personalized Avatar with levels instead of a general health-overview |

Helsana also stated, that they want a recommendation-system which suggest the user to do certain things based on data.
This is one of the main reason we chose to design one app for everything, because the recommendation-system would benefit from more data. That means that the app can suggest drinking more water if it finds a correlation to medical issues like headaches.

Home Screen  |  Medicine Card
:-------------------------:|:-------------------------:
![home_screen](https://github.com/distrustME/START-Hack-21/blob/master/doc/mockups/01_home_screen_v2.png)  |  ![medicine_screen](https://github.com/distrustME/START-Hack-21/blob/master/doc/mockups/04_medicine_fragment.png)

As you can already clearly see the home screen is simple and not overloaded. Each card color represents a different state of health for a specific category.
The grey cards are an exception, because they only represent relevant information to the user and are not scored.
| Color | Meaning |
| ------------- | ------------- |
| Green | Healthy |
| Yellow | Could be improved / Okay |
| Red | In bad condition |
| Grey | Information |

Each health-screen is similiar to every other health-screen. The main reason for this is to simplify the ui and learning process for the user. A suggestions card will tell the user about his current state of health in this section. Most of the time it will be used to suggest solutions to given problems in a specific health section, but if the the user is already on a healthy level it will still suggest cool things to try out. The recommendation-system would suggest a healthy user a new recipe to try out. This is just an example for a suggestion. Each screen will suggest different things. 


