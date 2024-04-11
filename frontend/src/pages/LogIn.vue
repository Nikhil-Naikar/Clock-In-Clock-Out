<template>
    <div class="loginpage">
        <div>
            <p class="sub-title">Please Enter Pin:</p>
            <input id="pin" name="pin" type="text" v-model="enteredPin"/>
        </div>
        <div v-if="invalidPin">
            <p class="errorMessage">Invalid Pin</p>
        </div>
        <div class="pin-layout">
            <base-button v-for="dig in digits" :key="dig" @click="updateEnteredPin(dig)"><p class="large-text">{{dig}}</p></base-button>            
        </div>
        <div>
            <base-button @click="clearEnteredPin"><p class="medium-text">Clear Pin</p></base-button>            
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data(){
        return{
            enteredPin: '',
            digits: [1,2,3,4,5,6,7,8,9],
            userData: null,
            invalidPin: false
        };
    },
    methods:{
        updateEnteredPin(digit){
            if (this.enteredPin.length !== 4){
                this.enteredPin += digit;
            }
        },
        clearEnteredPin(){
            this.enteredPin = '';
            this.resetButtonColors();
        },
        resetButtonColors() {
            // Reset button colors to default state
            const buttons = document.querySelectorAll('.base-button');
            buttons.forEach(button => {
                button.classList.remove('active'); // Remove any additional styles
            });
        },
        verifyPin(){
            axios.get(`http://localhost:1111/data/getUserInfo/${this.enteredPin}/2024-01-10`)
            .then(response => {
                // Handle successful response
                this.userData = response.data;
                console.log(this.userData);
                if (this.userData === null || Object.keys(this.userData).length === 0){
                    this.invalidPin = true
                    this.clearEnteredPin();
                }else{
                    if (this.userData.isClockedIn){
                        this.$router.push('/main/'+this.userData.name+'/true');
                    }else{
                        this.$router.push({path:'/main/'+this.userData.name+'/false', query: { pin: this.enteredPin}});
                    }
                }
            })
            .catch(error => {
                // Handle error
                console.error('Error fetching data:', error);
            });
        }
    },
    watch:{
        enteredPin(value){
            if (value.length === 4){
                //if user key is correct & clocked in, collect time clocked in and username, redirect to main page for option for clocking out
                //if user key is correct & not clocked in, collect username, redirect to main page for option for clocking in
                this.verifyPin()  
            }
            else if (value >= 1 && this.invalidPin === true){
                this.invalidPin = false;
            }
        }
    }
}
</script>

<style scoped>
.loginpage {
  text-align: center; /* Horizontally center the content */
  display: flex;
  flex-direction: column;
  align-items: center; /* Vertically center the content */
  height: auto; /* Set the height to 100% of the viewport height for vertical centering */
  justify-content: center; /* Center content both horizontally and vertically */
  background-color: white;
  margin-left: 25%;
  margin-right: 25%;
  border-radius: 0%;
  border: 5px solid black;
  padding: 50px;
}

.pin-layout{
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    width: 45%;
    margin: 3%
}

.errorMessage{
    color: red;
    font-weight: bold;
    font-size: 25px;
    margin-bottom: 0px;
}

.large-text {
    font-size: 25px;
    font-weight: bold;
}

.sub-title {
    font-size: 35px;
    font-weight: bold;
    margin-top: 0%;
    margin-bottom: 3%;
}

.medium-text {
    font-size: 20px;
    font-weight: bold;
}

input{
    font-size: 35px;
    text-align: center;
}

</style>