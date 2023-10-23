<template>
    <div class="loginpage">
        <div>
            <h2>Enter Your Pin</h2>
            <input id="pin" name="pin" type="text" v-model="enteredPin"/>
        </div>
        <div class="pin-layout">
            <base-button v-for="dig in digits" :key="dig" @click="updateEnteredPin(dig)"><p>{{dig}}</p></base-button>
        </div>
        <div>
            <base-button @click="clearEnteredPin">Clear Pin</base-button>
        </div>
    </div>
</template>

<script>
export default {
    data(){
        return{
            enteredPin: '',
            digits: [1,2,3,4,5,6,7,8,9]
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
        },
    },
    watch:{
        enteredPin(value){
            if (value.length === 4){
                //check if valid
                //get request to back end and send the pin
                //if valid, backend will return true and userid
                //if invalid, backend will return false
                this.$router.push('/main/0');
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
  height: 70vh; /* Set the height to 100% of the viewport height for vertical centering */
  justify-content: center; /* Center content both horizontally and vertically */
  background-color: white;
  margin-top: 3%;
  margin-left: 25%;
  margin-right: 25%;
}

.pin-layout{
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    width: 30%;
    margin: 3%;
}
p {
    font-size: large;
}

input{
    font-size: 25px;
    text-align: center;
}

</style>