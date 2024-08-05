# Clock In Clock Out App

<img width="700" alt="Screenshot 2023-11-04 at 4 55 23 PM" src="https://github.com/WonderBoi99/Clock-In-Clock-Out/assets/61436662/5586221a-cf4e-4a05-9a12-8f61ccfbb0ae">

## Tech Stack 🧰
-   HTML
-   CSS
-   JavaScript
-   Vue.js 
-   Pinia 
-   Java
-   Spring Boot 
-   SQL
-   MySQL
-   Docker
-   Layered architecture (Frontend <=> Backend <=> Database)

## Views 🧐
### What an employee would see:
<img width="700" alt="Screenshot 2023-11-04 at 4 55 11 PM" src="https://github.com/WonderBoi99/Clock-In-Clock-Out/assets/61436662/38ab7f22-bef4-4608-b0f8-78c363e7375a">
<img width="700" alt="Screenshot 2023-11-04 at 4 55 11 PM" src="https://github.com/WonderBoi99/Clock-In-Clock-Out/assets/61436662/3c18b734-1e22-4038-80e6-349ea8139360">
<img width="700" alt="Screenshot 2023-11-04 at 4 55 11 PM" src="https://github.com/WonderBoi99/Clock-In-Clock-Out/assets/61436662/e5ad7459-9b88-4250-a32b-1afc600599db">
<img width="700" alt="Screenshot 2024-03-20 at 8 38 39 PM" src="https://github.com/WonderBoi99/Clock-In-Clock-Out/assets/61436662/bf9ea891-f469-4c9b-8866-527afc173995">
<img width="700" alt="Screenshot 2024-03-20 at 8 39 26 PM" src="https://github.com/WonderBoi99/Clock-In-Clock-Out/assets/61436662/f2d2fac1-8242-43b9-8d42-8d03b7f68bb6">

# Funtionalities 📋
## Employee:
- Log In/Out (4 digit pin)
- Clock In/Out of shift
- View shift/pay History

# MySQL Tables:
<img width="700" alt="Screenshot 2024-03-20 at 8 38 39 PM" src="https://github.com/WonderBoi99/Clock-In-Clock-Out/assets/61436662/d50110c5-8ea7-4453-853a-6df2d986d6be">
<img width="700" alt="Screenshot 2024-03-20 at 8 39 26 PM" src="https://github.com/WonderBoi99/Clock-In-Clock-Out/assets/61436662/65206b66-bee1-4b7b-9a1d-0b980283c10f">

### My Restful APIs 🤓
| Method     | API URL                                      | Comments                                                              |
|------------|----------------------------------------------|---------------------------------------------------------------------------|
| GET        | `/data/getUserInfo/{pin}/{date}`             | Gets user info for a specific pin and date                                |
| GET        | `/data/shiftHistory/{pin}`                   | Retrieves the shift history for a specific pin                            |
| POST       | `/data/clock-in`                             | Clocks in a user with the provided data                                   |
| PUT        | `/data/clock-out`                            | Clocks out a user with the provided data                                  |
| PUT        | `/data/updateClockInStatus/{pin}/{status}`   | Updates the clock-in status for a specific pin                            |


# Next Steps when I have some time 🪜
### Add more Functionalities 📋
#### Employee:
- Be able to rate shift (1-5 stars) and leave anonymous feedback
   
#### Boss:
- Log In/Out
- Add/remove workers
- View feedback from workers
- View shift/pay history (more details than workers view)

#### Other:
- Setup CI/CD pipeline with Jenkins to deploy to AWS
  




