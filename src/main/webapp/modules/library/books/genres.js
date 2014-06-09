define(function(require) {

    var BaseCollection = require('base/collection');

    var Genres = BaseCollection.extend({
        url: 'http://localhost:8080/rest/genre',

        toOptions: function() {
            return this.map(function(genre) {
                return {
                    value: genre.get('name')
                };
            });
        }
    });

    return Genres;
});
