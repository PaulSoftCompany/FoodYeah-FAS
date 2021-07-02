package com.paulsoft.food.BDDTests.steps;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S9Steps {
    @Given("a user{int}")
    public void aUser(int arg0) {
    }

    @When("he opens an account with his card")
    public void heOpensAnAccountWithHisCard() {
    }

    @Then("the system shows a list of cards of the user")
    public void theSystemShowsAListOfCardsOfTheUser() {
    }

    @Given("a user{int} with no cards saved")
    public void aUserWithNoCardsSaved(int arg0) {
    }

    @When("he wants to see the information about his card")
    public void heWantsToSeeTheInformationAboutHisCard() {
    }

    @Then("the system shows a message showing that he has no cards saved")
    public void theSystemShowsAMessageShowingThatHeHasNoCardsSaved() {
    }

    @When("he see that he has no cards saved")
    public void heSeeThatHeHasNoCardsSaved() {
    }

    @Then("the system suggests to save a new card")
    public void theSystemSuggestsToSaveANewCard() {
    }
}
