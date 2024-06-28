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
            <base-button v-for="dig in digits" :key="dig" @click="updateEnteredPin(dig)" size="large-text" >{{dig}}</base-button>              
        </div>
        <div>
            <base-button @click="reset" size="medium-text" >Clear Pin</base-button>            
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import { useStorageStore } from '../stores/storage.js';

export default {
    data(){
        return{
            enteredPin: '',
            digits: [1,2,3,4,5,6,7,8,9],
            userData: null,
            invalidPin: false,
            store: useStorageStore()
        };
    },
    methods:{
        //update pin variable untli length in 4
        updateEnteredPin(digit){
            if (this.enteredPin.length !== 4){
                this.enteredPin += digit;
            }
        },
        // reset to default state
        reset() {
            this.enteredPin = '';
            const buttons = document.querySelectorAll('.base-button');
            buttons.forEach(button => {
                button.classList.remove('active'); // Remove any additional styles
            });
        },
        /* make request to GET API to check validatity of pin
        if exist, get user data, if user clocked in or out route to proper page
        /if not, trigger invalid pin message */
        verifyPin(){
            axios.get(`http://localhost:1111/data/getUserInfo/${this.enteredPin}/2024-01-10`)
            .then(response => {
                // Handle successful response
                this.userData = response.data;
                console.log(this.userData);
                if (this.userData === null || Object.keys(this.userData).length === 0){
                    this.invalidPin = true
                    this.reset();
                }else{
                    // store data
                    this.store.setName(this.userData.name);
                    this.store.setPin(this.enteredPin);
                    this.store.setStatus(this.userData.isClockedIn);
                    // send to home page
                    this.$router.push('/home');
                }
            })
            .catch(error => {
                // Handle error
                console.error('Error fetching data:', error);
            });
        }
    },
    watch:{
        /*
            if user key is correct & clocked in, collect time clocked in and username, redirect to main page for option for clocking out
            if user key is correct & not clocked in, collect username, redirect to main page for option for clocking in
        */
        enteredPin(value){
            if (value.length === 4){
                this.verifyPin();  
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

.sub-title {
    font-size: 35px;
    font-weight: bold;
    margin-top: 0%;
    margin-bottom: 3%;
}

input{
    font-size: 35px;
    text-align: center;
}

</style>