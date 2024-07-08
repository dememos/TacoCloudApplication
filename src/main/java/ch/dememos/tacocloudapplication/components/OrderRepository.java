package ch.dememos.tacocloudapplication.components;

import ch.dememos.tacocloudapplication.model.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
