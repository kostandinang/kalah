window.onload = function () {
    var startGameBtn = Utils.byId(Constants.START_GAME_BTN);
    var p1Input = gameInputs.player1Name;
    var p2Input = gameInputs.player2Name;
    //Start game on button click
    startGameBtn.onclick = function () {
        //Start Kalah Game if player names are defined
        if (p1Input.value && p2Input.value) {
            Kalah.start({
                houseNumber: 6,
                seedNumber: 1,
                player1Name: p1Input.value,
                player2Name: p2Input.value
            });
            disableInputsOnGameStart();
        }
    };

    /**
     * Disables player name inputs
     * and game start button
     */
    function disableInputsOnGameStart() {
        //Disable Inputs
        startGameBtn.disabled = "true";
        p1Input.setAttribute("disabled", "disabled");
        p2Input.setAttribute("disabled", "disabled");
    }
};