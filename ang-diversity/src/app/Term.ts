import { Person } from './Person';

export interface Term{
    termId: number;
    person: Person;
    termStart: number;
    termEnd: number;
    region: string;
    position: string;
    party: String;
}