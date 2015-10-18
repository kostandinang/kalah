/**
 * Kalah Game Starting point
 */
window.onload = function () {
    /**
     * Inputs
     */
    var startGameBtn = Utils.byId(Constants.START_GAME_BTN);
    var seedsSelect = Utils.byId(Constants.ids.SEED_NUM_SELECT);
    var p1Input = gameInputs.player1Name;
    var p2Input = gameInputs.player2Name;
    /**
     * Start game on start button click and deactivate inputs
     */
    startGameBtn.onclick = function () {
        //Start Kalah Game if player names are defined
        if (p1Input.value && p2Input.value) {
            Kalah.start({
                houseNumber: 6,
                seedNumber: seedsSelect.value,
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
        seedsSelect.setAttribute("disabled", "disabled");
        p1Input.setAttribute("disabled", "disabled");
        p2Input.setAttribute("disabled", "disabled");
    }
};