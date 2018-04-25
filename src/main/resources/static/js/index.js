document.addEventListener("DOMContentLoaded", function() {
    var element = document.querySelector('.bodyText');
    element.innerText = truncateText('.bodyText', 155)
});


document.addEventListener("DOMContentLoaded", function() {
    var element = document.querySelector('.recText');
    element.innerText = truncateText('.recText', 15)
});

function truncateText(selector, maxLength) {
    var element = document.querySelector(selector),
        truncated = element.innerText;

    if (truncated.length > maxLength) {
        truncated = truncated.substr(0,maxLength) + '...';
    }
    return truncated;
}