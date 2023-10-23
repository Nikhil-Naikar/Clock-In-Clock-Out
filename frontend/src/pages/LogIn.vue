<template>
    <div>
        <h1>Clock In / Clock Out</h1>
        <div>
            <label for="pin">Pin:</label>
            <input id="pin" name="pin" type="text" v-model="enteredPin"/>
        </div>
        <div>
            <button v-for="dig in digits" :key="dig" @click="updateEnteredPin(dig)">{{dig}}</button>
        </div>
        <button @click="clearEnteredPin">Clear Pin</button>
        <button @click="clearEnteredPin">Log In</button>
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
        }
    }
}
</script>