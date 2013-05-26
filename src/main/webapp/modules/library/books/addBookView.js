define(function(require) {

    require('css!./addBookView.css');
    var template = require('text!./addBookView.mustache'),
        mustache = require('mustache');

    var AddBookView = function(options) {
        var el = options.el;

        var render = function() {
            el.html(mustache.render(template));
        };

        return {
            render: render
        };
    };

    return AddBookView;
});
