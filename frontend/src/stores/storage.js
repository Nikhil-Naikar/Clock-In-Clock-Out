import { defineStore } from 'pinia'

export const useStorageStore = defineStore('storage', {
  state: () => ({
    name: '',
    pin: '',
    status: ''
  }),
  getters: {
    getName(state){
        return state.name;
    },
    getPin(state){
        return state.pin;
    },
    getStatus(state){
        return state.status;
    },
  },
  actions: {
    setName(name){
        this.name = name;
    },
    setPin(pin){
        this.pin = pin;
    },
    setStatus(status){
        this.status = status;
    }
  }
})