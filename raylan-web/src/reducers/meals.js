export const currentMeal = (state = { meal: undefined}, action) => {
    switch (action.type) {
        case 'SET_CURRENT_MEAL':
            return Object.assign({}, state, { meal: action.meal});
        default:
            return state;
    }
}