define(function() {

    return {
        expectToBeVisible: function() {
            expect(this.$el).not.toBeEmpty();
            expect(this.$el).not.toHaveClass('hide');
            return this;
        },
        expectToBeHidden: function() {
            expect(this.$el).toHaveClass('hide');
            return this;
        }
    }

});