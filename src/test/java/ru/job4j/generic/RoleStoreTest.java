package ru.job4j.generic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {
    @Test
    void whenAddAndFindThenRoleAdmin() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "admin"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("admin");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "admin"));
        Role result = store.findById("2");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRoleAdmin() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "admin"));
        store.add(new Role("1", "moderator"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("admin");
    }

    @Test
    void whenReplaceThenRoleIsModerator() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "admin"));
        store.replace("1", new Role("1", "moderator"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("moderator");
    }

    @Test
    void whenNoRoleToReplaceThenNoChanges() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "admin"));
        store.replace("3", new Role("10", "moderator"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("admin");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "admin"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoRoleToDeleteThenRoleIsAdmin() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "admin"));
        store.delete("2");
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("admin");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "admin"));
        boolean rsl = store.replace("1", new Role("1", "moderator"));
        assertThat(rsl).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "admin"));
        boolean rsl = store.replace("10", new Role("10", "moderator"));
        assertThat(rsl).isFalse();
    }

    @Test
    void whenDeleteOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "admin"));
        boolean rsl = store.delete("1");
        assertThat(rsl).isTrue();
    }

    @Test
    void whenDeleteNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "admin"));
        boolean rsl = store.delete("2");
        assertThat(rsl).isFalse();
    }
}