let app = new Vue({
    el: '#app',
    data: {
        message: 'Hello Vue!'
    },
    methods: {
        request: function () {
            axios.get( 'http://localhost:8080/cowsay/api/whatNumber' )
                .then( ( res ) => {
                    this.message = res.data;
                    console.log( res );
                } )
                .catch( ( res ) => {
                    console.error( res );
                } );
        }
    },
})