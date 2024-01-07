
// Определяем новый компонент под именем todo-item
Vue.component('messages-list', {
    props: ['messages'],
    template: '<div><div v-for="onemessage in messages">{{ onemessage.text }}</div></div>'
});

    var app = new Vue({
      el: '#app',
      template: '<messages-list :messages="messages" />',
      data: {
        messages: [
        {id: '123', text: '123454'},
        {id: '124', text: '23456'},
        {id: '125', text: '34567'}
        ]
      }
    })