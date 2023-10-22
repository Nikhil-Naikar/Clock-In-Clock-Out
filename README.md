# Clock-In-Clock-Out

# Description:
A simple Clocking In and Clocking Out application built for businesses. The purpose of this project is to practise Vue.js (components, routing, design), Java and SpringBoot (rest API, JUnit), Docker, CI/CD pipline (Jenkins) and using AWS (EC2 instances, MySQL database).

# Design Plan:
- Build MySQL database for storing manager and workers infromation (name, pin, hours, pay, feedback, rating)
- Build views for different pages (log in page, main page, feedback/rating page for workers, hours/pay summary page for workers, hours/pay summary page for manager, add/remove worker page, feedback/shift rating page for manager)
- Vue.js for frontend, 
- Java and sprint boot for backend rest api's and communication with database
- Plan to setup CI/CD pipline (github, Docker, jenkins, AWS EC2 instance) 
- Write some JUnit Tests

# Funtionalities:
## Manager:
- Log In/Out
- Add new workers and pin
- Remove workers and pin
- View feedback and rating from workers
- View total pay and hours
- View each workers pay and hour

## Workers:
- Log In/Out (4 digit pin)
- Clock In/Out
- 10 min unpaid break
- 30 min unpaid break
- Display total hours
- Display total pay
- Option to rate shift and leave feedback for manager


