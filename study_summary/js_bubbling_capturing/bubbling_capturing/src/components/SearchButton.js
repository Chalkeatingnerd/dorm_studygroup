const SearchButton = {
    init(el, color, title) {
        this.el = el;
        this.color = color;
        this.title = title;
        this.render();
        this.eventHandler();
    },
    eventHandler() {
        this.el.addEventListener('click', () => {
            const submitEvent = new CustomEvent('@submit', {detail: {color: this.color}});
            this.el.dispatchEvent(submitEvent);
        });
    }, 

    render() {
        const inputEl = `<button class="search" type="submit" style="background-color: ${this.color}; color: white;">
        ${this.title}
        </button>`;
        this.el.innerHTML = inputEl;
    },
};

export default SearchButton;