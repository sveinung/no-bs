define(function(require) {

    require('css!./addBookView.css');
    var template = require('text!./addBookView.mustache');
    var BaseView = require('base/view');
    var DropDownView = require('modules/components/dropdown/dropDownView');

    var AddBookView = BaseView.extend({
        events: {
            'click .cancel-button': 'cancelButtonClicked',
            'click .submit-button': 'submitButtonClicked'
        },

        initialize: function(options) {
            this.genres = options.genres;
            this.book = options.book;
            this.genresDropDown = new DropDownView({
                defaultOption: "Choose a genre"
            });
        },

        render: function() {
            this.renderTemplate(template);

            this.genresDropDown.setElement(this.$(".genres-dropdown")).renderWith({
                options: this.genres.toOptions()
            });

            return this;
        },

        cancelButtonClicked: function(event) {
            event.preventDefault();
            this.hide();
        },

        submitButtonClicked: function(event) {
            event.preventDefault();
            this.book.save({
                author: this.$('.author-input').val(),
                title: this.$('.title-input').val(),
                genre: this.genresDropDown.selected()
            });
            this.hide();
            this.trigger("book:added", this.book);
        },

        show: function() {
            this.book.clear();
            this.$el.removeClass('hide');
        },

        hide: function() {
            this.$el.addClass('hide');
        }
    });

    return AddBookView;
});
