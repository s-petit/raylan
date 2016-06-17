export const setCurrentMeal = (meal) => {
    return {
        type: 'SET_CURRENT_MEAL',
        meal
    };
}

export const setMeals = (meals) => {
    return {
        type: 'SET_MEALS',
        meals
    };
}

export function fetchMeal(mealDate) {
    return dispatch => {
        dispatch(loading(`meal with id ${mealDate}`));
        return fetch(`/meal/${mealDate}`)
            .then(r => r.json())
            .then(data => {
                dispatch(setCurrentMeal(data));
                dispatch(loaded(`meal with date ${mealDate}`));
            })
            .catch(error => dispatch(errorLoading(`error while fetching meal ${mealDate} : ${error.message}`)));
    };
}

export function fetchMeals() {
    return (dispatch, state) => {
        if (state().meals.lastUpdated + 60000 < Date.now()) { // caches data during 1mn
            dispatch(loading('Meals'));
            fetch('/meals')
                .then(r => r.json())
                .then(data => {
                    dispatch(updateMealsTimestamp());
                    dispatch(setMeals(data));
                    dispatch(loaded('Meals'));
                })
                .catch(error => dispatch(errorLoading(`error while fetching meals : ${error.message}`)));
        } else {
            dispatch(setMeals(state().meals.data));
        }
    };
}


//technical


export const loading = (what) => {
    return {
        type: 'LOADING',
        what
    };
}

export const loaded = (what) => {
    return {
        type: 'LOADED',
        what
    };
}

export const errorLoading = (error) => {
    return {
        type: 'ERROR',
        error
    };
}

export const updateMealsTimestamp = () => {
    return {
        type: 'UPDATE_MEALS_TIMESTAMP'
    };
}
